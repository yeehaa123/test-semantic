(ns offcourse.core
  (:require [reagent.core :as r]
            [ajax.core :refer [GET]]
            [offcourse.semantic :refer [Container Accordion Header
                                        AccordionTitle AccordionContent]]
            [offcourse.layout :refer [Layout]]
            [offcourse.sidebar :refer [Sidebar]]
            [offcourse.course-card :refer [CourseCard]]))

(defonce appstate (r/atom {:sidebar-visible? false}))

(defn App [appstate]
  [Layout appstate
   [Sidebar appstate]
   [Container
    [Accordion {:default-active-index 1}
     [AccordionTitle  [Header "Global"]]
     [AccordionContent
      [:div.ui.cards.stackable.doubling
       (map-indexed (fn [index title]
                      (.log js/console title)
                      ^{:key index} [CourseCard title]) {:services_info (:global @appstate)})]]
     [AccordionTitle  [Header "Development"]]
     [AccordionContent
      [:h1.ui.small.header "Landing Pages"]
      [:div.ui.cards
       (map-indexed (fn [index title]
                      ^{:key index} [CourseCard title]) (:landing_pages (:development @appstate)))]]]]])

(GET "https://s3.amazonaws.com/offcourse-services-info-global/global.json"
     {:handler #(swap! appstate assoc-in [:global] %)
      :error-handler #(.log js/console %)
      :response-format :json
      :keywords? true})

(GET "https://s3.amazonaws.com/offcourse-services-info-global/development.json"
     {:handler #(swap! appstate assoc-in [:development] %)
      :error-handler #(.log js/console %)
      :response-format :json
      :keywords? true})

(defn render-simple []
  (r/render-component [App appstate]
                      (. js/document (querySelector "#container"))))
