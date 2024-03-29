(ns dev.compiler
  (:require [cljs.build.api :as build]
            [cljs.env :as env]
            [shadow.cljs.devtools.api]
            [shadow.cljs.devtools.server]
            [clojure.java.io :as io]
            [clojure.string :as str]
            [org.httpkit.server :as server]))

;; ClojureScript compiler integration

(defn compile-stuff
  []
  (let [cenv (env/default-compiler-env)
        source (io/file "src/clj/browser/module.cljs")
        opts {
              :output-to "out/main.js"
              :output-dir "out"
              :verbose true
              }]
    (env/with-compiler-env cenv
      (build/build source opts cenv))))

(defn prod-compile-stuff
  []
  (let [cenv (env/default-compiler-env)
        source (io/file "src/clj/browser/module.cljs")
        opts {
              :output-to "out-prod/main.js"
              :output-dir "out-prod"
              :verbose true
              :optimizations :advanced
              }]
    (env/with-compiler-env cenv
                           (build/build source opts cenv))))

;; Shadow-CLJS
(defn start-shadow-cljs
  []
  (shadow.cljs.devtools.server/start!)
  (shadow.cljs.devtools.api/watch :out))

;; Web server integration

(def root-path (.getAbsolutePath (io/file ".")))

(defn handle-request
  [request]
  (println request)
  (let [uri (:uri request)]
    (cond
      (contains? #{"/" "/index.html"} uri)
      {:status 200
       :body   (slurp "index.html")}

      (str/starts-with? uri "/out/")
      (let [f (io/file (str/replace-first uri "/out" "out"))]
        (if (.exists f)
          {:status 200
           :body f}
          {:status 404
           :body "Not Found"}))

      :else
      {:status 404
       :body   "Not found !"})))

(defn start-server
  []
  (server/run-server
    (fn [request]
      (handle-request request))

    {:port 12345}))
