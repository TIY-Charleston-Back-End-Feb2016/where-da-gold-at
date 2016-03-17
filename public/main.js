var $ = require('jquery');
var Router = require('./router');
var Collection = require('./collection');
var CollectionView = require('./collectionView');
var FormView = require('./formView');
$(document).ready(function () {
  var sightings = new Collection();
  sightings.fetch().then(function (data) {
    new CollectionView({collection: sightings});
    var addSightingForm = new FormView({collection: sightings});
    $('.col-md-4').html(addSightingForm.render().el);
  });


});
