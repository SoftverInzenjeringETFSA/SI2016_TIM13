import Ember from 'ember';
import config from './config/environment';

const Router = Ember.Router.extend({
  location: config.locationType,
  rootURL: config.rootURL
});

Router.map(function() {
  this.route('login');
  this.route('new-panel');
  this.route('form-upload');
  this.route('form-validation');
  this.route('my-panels');
  this.route('notification');
  this.route('profile');
  this.route('home');
});

export default Router;
