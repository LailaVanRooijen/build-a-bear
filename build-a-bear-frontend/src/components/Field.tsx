import React from "react";

const Field: React.FC<FieldProps> = ({ style, content, label, textColor }) => {
  return (
    <div
      className={`${style} flex p-6 mt-6 rounded-lg font-extrabold text-xl grid grid-cols-9`}
    >
      <p className={`${"col-span-3"} ${textColor} text-2xl`}>{label}</p>
      <p className={`${"col-span-6"} ${textColor}`}>{content}</p>
    </div>
  );
};

export default Field;

interface FieldProps {
  style: string;
  content: string;
  label: string;
  textColor: string;
}
