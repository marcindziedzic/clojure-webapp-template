(ns webapp.api
  (:use [ring.util.response :only [response]]))

(defn exemplary-function []
  (response ["Hello" "Word"]))
