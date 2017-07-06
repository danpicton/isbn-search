(ns isbn-search.core
  (:require [clj-isbn.core :as isbn]
            [clj-http.client :as client]
            [clojure.data.json :as json])
  (:gen-class))

(defn book
 "Searches for a book."
 ([terms]
  (book terms 1))
 ([terms n]
  (take n
    (:items
      (json/read-str
        (:body
         (client/get (str "https://www.googleapis.com/books/v1/volumes")
           {:query-params {"q" terms}}))
       :key-fn #(keyword %))))))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

;(:totalItems (json/read-str (:body (book "tao te ching")) :key-fn #(keyword %)))
