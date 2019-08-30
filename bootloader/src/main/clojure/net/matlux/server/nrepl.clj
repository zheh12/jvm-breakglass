(ns net.matlux.server.nrepl
	(:require [nrepl.server :as nrepl-server]))

(def server nil)

(defn nrepl-handler []
	(require 'cider.nrepl)
	(ns-resolve 'cider.nrepl 'cider-nrepl-handler))

(defn safe-stop-server [server]
	(when (not (nil? server))
		(nrepl-server/stop-server server)))

(defn start-server-now [port]
  (alter-var-root (var server) (fn [old-server]
									(safe-stop-server old-server)
									(nrepl-server/start-server
										:port port
										:handler (nrepl-handler)))))

(defn stop-server-now []
	(alter-var-root (var server) (fn [old-server]
									(safe-stop-server old-server)
									nil)))