(ns cl-java-introspector.spring)

(require '[clojure.walk :only [walk prewalk postwalk]])
(use 'clojure.reflect 'clojure.pprint)
(use '[cl-java-introspector.core :exclude [get-obj]])

(import '(net.matlux NreplServerSpring))

(defn get-beans []
    (into [] (.getBeanDefinitionNames (.getApplicationContext NreplServerSpring/instance)))  
)

(defn get-bean [^String bean-name] 
  (.getObj NreplServerSpring/instance bean-name))

;(def get-obj get-bean)









