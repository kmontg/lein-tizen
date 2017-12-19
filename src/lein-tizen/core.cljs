(ns lein-tizen.core
    (:require [reagent.core :as r]))

(enable-console-print!)

; (println "Hello World")

(defonce timer (r/atom (js/Date.)))

(defonce time-color (r/atom "#f34"))

(defonce time-update (js/setInterval
                      #(reset! timer (js/Date.)) 1000))

(defn clock []
  (let [time-str (-> @timer .toTimeString (clojure.string/split " ") first)]
    [:div.ui-page.ui-page-active
     {:style {:color @time-color}}
     [:header.ui-header.ui-header-big
      [:h2.ui-title
       time-str]]]))

(defn render-clock []
  (r/render [clock]
    (js/document.getElementById "app")))

(defn on-js-reload []
  (render-clock))

(render-clock)