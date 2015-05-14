window.RootCopy = function(origin, destination, callback, err) {
    cordova.exec(callback, err, "RootCopy", "copy", [origin, destination]);
};