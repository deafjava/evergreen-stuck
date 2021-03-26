(defproject stuckevergreen "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[etaoin                  "0.4.1"]
                 [org.clojure/clojure     "1.10.0"]
                 [org.clojure/data.json   "2.0.1"]
                 [ring/ring-core          "1.9.2"]
                 [ring/ring-jetty-adapter "1.9.2"]]
  :main ^:skip-aot stuckevergreen.core
  :repl-options {:init-ns stuckevergreen.core})
