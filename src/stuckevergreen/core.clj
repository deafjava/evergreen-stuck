(ns stuckevergreen.core
  (:use ring.adapter.jetty)
  (:require [stuckevergreen.controller.isstuck :as controller.isstuck]))

(defn handler [_]
  {:status  200
   :headers {"Content-Type" "application/json"}
   :body    (controller.isstuck/evergreen)})

(defn -main
  [& _]
  (run-jetty handler {:port 80}))