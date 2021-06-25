const getters = {
  sidebar: state => state.app.sidebar,
  device: state => state.app.device,
  token: state => state.user.token,
  avatar: state => state.user.avatar,
  name: state => state.user.name,
  roles: state => state.user.roles,
  resource: state => state.session.resource,
  currentUser: state => state.user.currentUser,
  // session
  sessionData: state => state.session.data,
  // settings
  getShowLogin: state => state.settings.showLogin,
  productHost: state => state.settings.productHost,
}
export default getters
