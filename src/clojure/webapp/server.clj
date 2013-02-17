(ns webapp.server
  (:use [compojure.core :exclude [routes]]
        [compojure.route :only [resources not-found]]
        [ring.middleware.params :only [wrap-params]]
        [ring.adapter.jetty :only [run-jetty]])
  (:require [webapp.pages]))

(defroutes routes
  (GET "/" [] (webapp.pages/home))

  (resources "/")
  (not-found "Page not found"))

(def handler
  (wrap-params routes))

(defn- get-port []
  (Integer/parseInt (or (System/getenv "PORT") "8080")))

(defn -main []
  (run-jetty handler {:port (get-port)}))
