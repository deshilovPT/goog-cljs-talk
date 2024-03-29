(ns browser.module
  (:require ["object-assign" :as assign]))

(defn simple-function [b]
  (let [a 1]
    (+ a b)))

(defn console-out [a]
  (js/console.log a))

(console-out (simple-function 1))

(defn test1 []
  (let [a #js {}]
    (assign a #js { :foo "foo" })
    (js/console.log a)))

(test1)

