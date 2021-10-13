(ns app.hello
  (:require [app.events :as events]
            [app.subs :as subs]
            [re-frame.core :as re-frame]
            [reagent.core :as r]))

(defn click-counter [click-count]
  [:div
   "The atom " [:code "click-count"] " has value: "
   @click-count ". "
   [:input {:type "button" :value "Click me!"
            :on-click #(swap! click-count inc)}]])

(def click-count (r/atom 0))

(defn hello []
  (let [name (re-frame/subscribe [::subs/name])]
    [:<>
     [:p "Hello, repro is running!"]
     [:p "Here's an example of using a component with state:"]
     [:p "Name: " @name]
     [click-counter click-count]
     [:button {:on-click #(re-frame/dispatch [::events/change-name "test"])}
      "name changer"]]))
