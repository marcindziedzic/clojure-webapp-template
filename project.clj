(defproject webapp "0.1.0-SNAPSHOT"
  :description "Clojure WebApp Template"
  :url "http://marcindziedzic.com"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.4.0"]
		 [ring "1.1.8"]
		 [compojure "1.1.5"]
		 [enlive "1.0.1"]
		 [com.taoensso/carmine "1.2.1"]]
  :plugins [[lein-ring "0.7.5"]]

  :source-paths ["src/clojure"]
  :resource-paths ["resources"]
  :javac-options ["-target" "1.7" "-source" "1.7" "-Xlint:-options"]

  :main webapp.server

  :ring {:handler webapp.server/handler
         :auto-refresh? false}

  :test-selectors {:default (fn [m] (not (or (:integration m) (:system m))))
                   :integration :integration
                   :system :system}

  :profiles {
              :dev { :test-paths ["test/clojure"]
                     :dependencies [[clj-webdriver "0.6.0-beta2"]
                                    [expectations "1.4.24"]
                                    [junit "4.8.1"]]
                     :plugins [[lein-autoexpect "0.2.5"]
                               [lein-expectations "0.0.7"]]}

              :production { :mirrors {"central" "http://s3pository.herokuapp.com/maven-central" }}})
	
