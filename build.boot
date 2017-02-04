(set-env!
 :source-paths    #{"src/cljs" "src-dev/cljs"}
 :resource-paths #{"resources"}
 :dependencies '[[adzerk/boot-cljs              "1.7.228-1"      :scope "test"]
                 [adzerk/boot-cljs-repl         "0.3.3"          :scope "test"]
                 [adzerk/boot-reload            "0.4.12"         :scope "test"]
                 [ring/ring-devel               "1.6.0-beta5"    :scope "test"]
                 [com.cemerick/piggieback       "0.2.2-SNAPSHOT" :scope "test"]
                 [org.clojure/tools.nrepl       "0.2.12"         :scope "test"]
                 [pandeiro/boot-http            "0.7.3"          :scope "test"]
                 [weasel                        "0.7.0"          :scope "test"]
                 [binaryage/devtools            "0.8.3"          :scope "test"]
                 [binaryage/dirac               "0.8.6"          :scope "test"]
                 [powerlaces/boot-cljs-devtools "0.1.2"          :scope "test"]
                 [metosin/ring-http-response    "0.8.0"]
                 [org.clojure/clojurescript     "1.9.293"]
                 [reagent                       "0.6.0"]
                 [cljs-ajax                     "0.5.8"]
                 [compojure                     "1.6.0-beta1"]
                 [hiccup                        "1.0.5"]
                 [cljsjs/semantic-ui-react      "0.64.0-0"]])

(require
 '[adzerk.boot-cljs              :refer [cljs]]
 '[adzerk.boot-cljs-repl         :refer [cljs-repl start-repl]]
 '[adzerk.boot-reload            :refer [reload]]
 '[powerlaces.boot-cljs-devtools :refer [cljs-devtools]]
 '[pandeiro.boot-http            :refer [serve]])

(deftask dev []
  (set-env! :source-paths #(conj % "src-dev/cljs" "src-dev/clj"))
  (task-options! target {:dir #{"dev/"}}
                 serve {:handler 'history-handler/app}
                 reload {:on-jsload 'offcourse.main/reload}
                 cljs {:source-map true
                       :optimizations :none})
  (comp (serve)
        (watch)
        (speak)
        (reload)
        (cljs-repl)
        (cljs-devtools)
        (cljs)
        (target)))
