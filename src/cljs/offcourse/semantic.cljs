(ns offcourse.semantic
(:require [reagent.core :as r]
          [cljsjs.semantic-ui-react]))

(def Container   (r/adapt-react-class (.-Container js/semanticUIReact)))
(def JSSegment (.-Segment js/semanticUIReact))
(def Segment     (r/adapt-react-class (.-Segment js/semanticUIReact)))
(def Header      (r/adapt-react-class (.-Header js/semanticUIReact)))
(def Button      (r/adapt-react-class (.-Button js/semanticUIReact)))

(def JSMenu      (.-Menu js/semanticUIReact))
(def Menu        (r/adapt-react-class (.-Menu js/semanticUIReact)))

(def JSCard      (.-Card js/semanticUIReact))
(def Card        (r/adapt-react-class JSCard))
(def CardContent (r/adapt-react-class (.-Content JSCard)))
(def CardHeader  (r/adapt-react-class (.-Header JSCard)))

(def JSSidebar      (.-Sidebar js/semanticUIReact))
(def SemanticSidebar        (r/adapt-react-class JSSidebar))
(def SidebarPushable (r/adapt-react-class (.-Pushable JSSidebar)))
(def SidebarPusher   (r/adapt-react-class (.-Pusher JSSidebar)))

(def JSAccordion      (.-Accordion js/semanticUIReact))
(def Accordion        (r/adapt-react-class JSAccordion))
(def AccordionTitle   (r/adapt-react-class (.-Title JSAccordion)))
(def AccordionContent (r/adapt-react-class (.-Content JSAccordion)))
