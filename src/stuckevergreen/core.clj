(ns stuckevergreen.core
  (:use ring.adapter.jetty)
  (:require [stuckevergreen.diplomat.http :as diplomat.http])
  (:gen-class))

(def path-chromedriver "/app/.chromedriver/bin/chromedriver")
(def path-google-chrome "/app/.apt/usr/bin/google-chrome")

(defn handler [_]
  {:status  200
   :headers {"Content-Type" "application/json"}
   :body    (diplomat.http/isstillstuck)})

(defn -main
  [& _]
  (let [port (Integer/parseInt (System/getenv "PORT"))]
    (run-jetty handler {:port         port
                        :path-driver  path-chromedriver
                        :path-browser path-google-chrome})))
