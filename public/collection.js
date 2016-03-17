var Backbone = require('backbone');
// sightings model
module.exports = Backbone.Collection.extend({
  url: '/sightings',
  initialize: function () {
    console.log("sightings collection has been created.");
  }

});
