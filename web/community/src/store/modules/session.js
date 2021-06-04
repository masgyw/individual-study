import { mutationsName } from '../mutation-types'

const state = {
  service: "",
  resource: "", // target resource
  data: null
}

const mutations = {
  [mutationsName.SET_SESSION_RESOURCE.key]: (state, resource) => {
    state.resource = resource;
  },
  [mutationsName.SET_SESSION_DATA.key]: (state, data) => {
    state.data = data;
  },
  [mutationsName.SET_SESSION_SERVICE.key]: (state, service) => {
    state.service = service;
  },
}

const actions = {
  changeResource({ commit }, { resource }) {
    commit(mutationsName.SET_SESSION_RESOURCE.key, resource);
  },
  changeData({ commit }, data) {
    commit(mutationsName.SET_SESSION_DATA.key, data)
  },
}

export default {
  namespaced: true,
  state,
  mutations,
  actions
}