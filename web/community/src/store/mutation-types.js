const SESSION = "session";

const mutationsName = {
  // module session
  SET_SESSION_RESOURCE: {
    key: "SET_SESSION_RESOURCE",
    domain: SESSION
  },
  SET_SESSION_DATA: {
    key: "SET_SESSION_DATA",
    domain: SESSION
  },
  SET_SESSION_SERVICE: {
    key: "SET_SESSION_SERVICE",
    domain: SESSION
  },
  UPDATE_SESSION: {
    key: "UPDATE_SESSION",
    domain: SESSION
  },

  SET_USER_CURRENT: {
    key: "SET_USER_CURRENT",
    domain: "user"
  },


}

const getMutationType = function (obj) {
  return obj.domain + "/" + obj.key;
}

export {
  mutationsName,
  getMutationType
}