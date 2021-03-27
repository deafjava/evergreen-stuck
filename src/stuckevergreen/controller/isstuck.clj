(ns stuckevergreen.controller.isstuck
  (:require [etaoin.api :as wd]
            [clojure.data.json :as json]
            [clojure.string :as str]))

(defn- seek-status []
  (let [driver (wd/chrome-headless)]
    (try (do
           (wd/go driver "https://istheshipstillstuck.com/")
           (wd/wait-exists driver {:tag :a})
           (-> (wd/get-element-text driver {:tag :a})
               str/trim
               str/lower-case))
         (catch Exception _fallback (str "yes.")))))

(defn evergreen []
  (json/write-str {:status (if (= "yes." (seek-status)) :yes :no)}))
