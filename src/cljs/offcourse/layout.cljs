(ns offcourse.layout
  (:require [offcourse.semantic :refer [SidebarPushable Container Segment JSSegment
                                        Header Button SidebarPusher]]))

(defn Layout [appstate sidebar content]
  [SidebarPushable {:as JSSegment}
   [Segment {:inverted true
             :color :red}
    [Container
     [Header {:as :h1
              :inverted true}
      "Offcourse"]
     #_[Button {:onClick #(swap! appstate (fn [state] (update-in state [:sidebar-visible?] not)))}]]]
   sidebar
   [SidebarPusher content]])
