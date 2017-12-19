(defproject lein-tizen "0.1.0-SNAPSHOT"
    :dependencies [[org.clojure/clojure "1.8.0"]
                   [org.clojure/clojurescript "1.9.908"]
                   [reagent "0.8.0-alpha2"]]
    :plugins [[lein-figwheel "0.5.13"]]
    :clean-targets ^{:protect false} [:target-path "resources/public/js/compiled/out"]
    :figwheel {:server-ip "0.0.0.0"}
    :cljsbuild {
      :builds [{:id "dev"
                :source-paths ["src"]
                :figwheel {:websocket-host "10.0.2.2" 
                           :heads-up-display false
                           :on-jsload "lein-tizen.core/on-js-reload"}
                :compiler {:main "lein-tizen.core"
                           :asset-path "js/compiled/out"
                           :output-to "resources/public/main.js"
                           :output-dir "resources/public/js/compiled/out"}}]})