(ns stuckevergreen.diplomat.http
  (:require [stuckevergreen.controller.isstuck :as controller.isstuck]))


(defn isstillstuck []
  (controller.isstuck/evergreen))
