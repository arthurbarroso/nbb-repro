(ns app.events
  (:require [app.db :refer [default-db]]
            [re-frame.core :as re-frame]))

(re-frame/reg-event-db
  ::init-db
  (fn [_ _]
    default-db))

(re-frame/reg-event-db
  ::change-name
  (fn [db [_ v]]
    (assoc db :name v)))
