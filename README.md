==========
RootCopy Cordova Plugin
==========

This cordova plugin allows you to copy files that can only be copied with root permissions in android apps. There is room for improvement: move files, delete files, chmod only, etc.

==========
USAGE
==========

```javascript
<script>
window.RootCopy("/path/to/file", '/path/to/destinationFile', function(success) {
  // do something after copy
}, function(err) {
  // handle the copy fail
});
</script>
```
