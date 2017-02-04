(ns offcourse.course-card
  (:require [offcourse.semantic :refer [Card CardContent CardHeader Accordion
                                        AccordionTitle AccordionContent Button]]))

(defn CourseCard [[title info]]
  [Card
   [CardContent
    [CardHeader title]]
   [CardContent
    (map-indexed (fn [index [title val]] ^{:key title} [:div.ui.padded.segment
                                                        [:div.ui.top.attached.label (name title)]
                                                        [:p.tiny val]]) info)]])
