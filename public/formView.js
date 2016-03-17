var Backbone = require('backbone');
var _ = require('underscore');
var tmpl = require('./templates');
var Model = require('./model.js');
// Form view
module.exports = Backbone.View.extend({
  tagName: 'section',
  template: _.template(tmpl.form),
  events: {
    'submit form': 'submitSighting'
  },
  submitSighting: function (event) {
    event.preventDefault();
    this.model.set({
      photo: this.$el.find('input[name="photo"]').val(),
      location: this.$el.find('input[name="location"]').val(),
      description: this.$el.find('textarea[name="description"]').val(),
    });
    this.model.save();
    this.collection.add(this.model);
    this.model = new Model({});
  },
  initialize: function () {
    if(!this.model) {
      this.model = new Model({});
    }
  },

  render: function () {
    var markup = this.template(this.model.toJSON());
    this.$el.html(markup);
    return this;
  }
})
