// jest-dom adds custom jest matchers for asserting on DOM nodes.
// allows you to do things like:
// expect(element).toHaveTextContent(/react/i)
// learn more: https://github.com/testing-library/jest-dom
// eslint-disable-next-line import/no-extraneous-dependencies
import "@testing-library/jest-dom";
import Enzyme from "enzyme";
import Adapter from "@wojtekmaj/enzyme-adapter-react-17";

import Chance from "chance";

export const chance = new Chance();

/**
 * https://github.com/enzymejs/enzyme/issues/2429
 */
Enzyme.configure({ adapter: new Adapter() });
