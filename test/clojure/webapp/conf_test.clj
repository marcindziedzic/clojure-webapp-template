(ns webapp.conf-test
  (:use [webapp.conf :only [parse-uri]]
        [expectations]))

(given (parse-uri "scheme://user:password@example.com:8000/")
  (expect
    :host "example.com"
    :port 8000
    :user "user"
    :password "password"))

(given (parse-uri "scheme://example.com:8000")
  (expect
    :host "example.com"
    :port 8000
    :user ""
    :password nil))