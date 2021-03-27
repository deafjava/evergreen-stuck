(defproject stuckevergreen "0.1.0-SNAPSHOT"
  :description "Codebase of a RESTful service to check if Evergreen is stuck at Suez Channel! Enjoy!"
  :url "https://github.com/deafjava/evergreen-stuck"
  :license {:name "GNU General Public License v3.0"
            :url "https://www.gnu.org/licenses/"}
  :dependencies [[etaoin                  "0.4.1"]
                 [org.clojure/clojure     "1.10.0"]
                 [org.clojure/data.json   "2.0.1"]
                 [ring/ring-core          "1.9.2"]
                 [ring/ring-jetty-adapter "1.9.2"]]
  :main ^:skip-aot stuckevergreen.core
  :min-lein-version "2.0.0"
  :jvm-opts ["-agentlib:jdwp=transport=dt_socket,server=y,suspend=n"]
  :repl-options {:init-ns stuckevergreen.core}
  :profiles {:production {:env {:production true}}})
