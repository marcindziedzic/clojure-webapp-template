(ns webapp.pages
  (:use [net.cgrand.enlive-html :only [deftemplate defsnippet
                                        content any-node]]))

(deftemplate layout "views/layout.html"
  [{:keys [main]}]
  [:body] (content main))


(defsnippet index "views/index.html" [:body :> any-node] []
  )

(defn home []
  (layout {:main (index)}))