(ns script
  (:require [app.hello :refer [hello]]
            [reagent.dom.server :as dom-server]))

(defn layout [{:keys [page-title]}]
  [:div
   [:div
    [:div
     (when (not (nil? page-title))
       [:h3
        page-title])]
    [:div]]])

(defn render-server []
  (dom-server/render-to-string [hello]))

(println (render-server))
