module.exports = {
  sighting: [
    "<img src='<%= photo %>'>",
    "<h3>Location: <%= location %></h3>",
    "<p><%= description %>"
  ].join(''),
  form: [
    '<form class="">',
      '<input type="text" name="location" placeholder="Location">',
      '<input type="text" name="photo" placeholder="Photo (URL)">',
      '<textarea name="description" rows="8" cols="40"></textarea>',
      '<button type="submit" name="button">Report Sighting</button>',
    '</form>'
  ].join('')
}

// picture, desc, location
