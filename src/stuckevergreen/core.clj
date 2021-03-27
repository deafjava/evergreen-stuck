(ns stuckevergreen.core
  (:use ring.adapter.jetty)
  (:require [stuckevergreen.diplomat.http :as diplomat.http])
  (:gen-class))

(defn app [_]
  {:status  200
   :headers {"Content-Type" "application/json"}
   :body    (diplomat.http/isstillstuck)})

(let [port (Integer/parseInt (System/getenv "PORT"))]
  (run-jetty app {:port port
                  :path-driver "/app/.chromedriver/bin/chromedriver"
                  :path-browser "/app/.apt/usr/bin/google-chrome"}))
