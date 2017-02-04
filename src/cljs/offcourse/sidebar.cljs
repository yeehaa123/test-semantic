(ns offcourse.sidebar
  (:require [offcourse.semantic :refer [SemanticSidebar JSMenu]]))

(defn Sidebar [appstate]
  [SemanticSidebar {:as JSMenu
                  :animation :overlay
                  :width "thin"
                  :direction "right"
                  :vertical true
                  :inverted true
                  :visible (:sidebar-visible? @appstate)}])
