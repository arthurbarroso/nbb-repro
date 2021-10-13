(ns app.core
  "This namespace contains your application and is the entrypoint for 'yarn start'."
  (:require [app.db :refer [default-db]]
            [app.events :as events]
            [app.hello :refer [hello]]
            [re-frame.core :as re-frame]
            [reagent.dom :as r]))

(defn ^:dev/after-load render
  "Render the toplevel component for this app."
  []
  (re-frame/clear-subscription-cache!)
  (re-frame/dispatch [::events/init-db])
  (r/render [hello] (.getElementById js/document "app")))

(defn ^:export main
  "Run application startup logic."
  []
  (render))
