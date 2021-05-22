import React from "react";
import { color, ColorProps } from "styled-system";
import styled from "styled-components";

interface Props {
  dataType?: string;
}

const H1 = styled.h1<any>`
  ${color}
`;

export const Title: React.FC<Props & ColorProps> = ({
  children,
  dataType,
  ...props
}) => {
  console.log("");
  return (
    <H1 data-type={dataType} {...props}>
      {children}
    </H1>
  );
};

Title.defaultProps = {
  dataType: "title",
};
