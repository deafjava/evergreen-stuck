(ns stuckevergreen.core
  (:use ring.adapter.jetty)
  (:require [stuckevergreen.diplomat.http :as diplomat.http]))

(defn handler [_]
  {:status  200
   :headers {"Content-Type" "application/json"}
   :body    (diplomat.http/isstillstuck)})

(defn -main
  [& _]
  (run-jetty handler {:port 80}))
