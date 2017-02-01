(ns offcourse.main
  (:require [offcourse.core :refer [render-simple]]))

(defn init []
  (render-simple))

(defn reload []
  (render-simple))

(defn stop [])
