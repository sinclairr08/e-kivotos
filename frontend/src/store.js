import { createStore } from "vuex";

export const MAX_VALUE = 100000.0;
export const UNIT_VALUE = 10000.0;

export const ADD_COST = "ADD_COST";
export const INIT_COST = "INIT_COST";
export const CLICK_CARD = "CLICK_CARD";

export default createStore({
  state: {
    costValue: 0.0,
    cards: [
      { name: "세리카", cost: 2 },
      { name: "이오리", cost: 3 },
      { name: "아루", cost: 4 },
      { name: "마키", cost: 5 },
      { name: "이로하", cost: 6 },
      { name: "히나", cost: 7 },
    ],
    orders: [...Array(6).keys()],
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
  },
});
