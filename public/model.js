var Backbone = require('backbone');
// sightings model
module.exports = Backbone.Model.extend({
  urlRoot: '/sightings',
  initialize: function () {
    console.log("sightings model has been created.");
  }
});
