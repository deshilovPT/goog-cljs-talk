(ns browser.module)

(defn simple-function [b]
  (let [a 1]
    (+ a b)))

(defn console-out [a]
  (js/console.log a))

(console-out (simple-function 1))
