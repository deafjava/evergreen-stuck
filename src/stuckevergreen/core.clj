(ns stuckevergreen.core
  (:use ring.adapter.jetty)
  (:require [stuckevergreen.diplomat.http :as diplomat.http])
  (:gen-class))

(defn handler [_]
  {:status  200
   :headers {"Content-Type" "application/json"}
   :body    (diplomat.http/isstillstuck)})

(defn -main
  [& _]
  (let [port (Integer/parseInt (System/getenv "PORT"))]
    (run-jetty handler {:port         port
                        :path-driver  "/app/.chromedriver/bin/chromedriver"
                        :path-browser "/app/.apt/usr/bin/google-chrome"})))
