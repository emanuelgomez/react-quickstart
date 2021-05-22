import { shallow } from "enzyme";
import React from "react";
import { Title } from "../Title";
import { chance } from "../../../setupTests";

describe("Title", () => {
  test("renders without error", () => {
    const color = chance.color();
    const children = chance.string();
    // Given

    // When
    const actual = shallow(<Title color={color}>{children}</Title>);

    // Then
    expect(actual.prop("data-type")).toEqual("title");
    expect(actual.prop("color")).toEqual(color);
    expect(actual.children().text()).toEqual(children);
  });
});
