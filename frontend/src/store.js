import { createStore } from "vuex";

export const MAX_VALUE = 100000.0;
export const UNIT_VALUE = 10000.0;

export const ADD_COST = "ADD_COST";
export const INIT_COST = "INIT_COST";
export const CLICK_CARD = "CLICK_CARD";
export const CHANGE_STATUS = "CHANGE_STATUS";

export default createStore({
  state: {
    costValue: 0.0,
    cards: [],
    orders: [...Array(6).keys()],
    statusCode: 200,
    statusMessage: "OK",
  },
  mutations: {
    [ADD_COST](state, { speed, regen }) {
      const addCostValue = speed * regen;

      if (state.costValue + addCostValue <= MAX_VALUE) {
        state.costValue += addCostValue;
        return true;
      }
      state.costValue = MAX_VALUE;
      return false;
    },
    [INIT_COST](state) {
      state.costValue = 0.0;
    },
    [CLICK_CARD](state, idx) {
      const { cost } = state.cards[state.orders[idx]];
      const cardCostValue = cost * UNIT_VALUE;

      if (state.costValue >= cardCostValue) {
        state.costValue -= cardCostValue;
        state.orders.push(state.orders[idx]);
        state.orders[idx] = state.orders[3];
        state.orders.splice(3, 1);
      }
    },
    [CHANGE_STATUS](state, { code, message }) {
      state.statusCode = code;
      state.statusMessage = message;
    },
  },
});
