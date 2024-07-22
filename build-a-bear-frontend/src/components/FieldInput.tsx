import { useState } from "react";

const FieldInput: React.FC<FieldInputProps> = ({
  label,
  content,
  type,
  style,
  bgAndTxt,
  handleChange,
}) => {
  const [value, setValue] = useState<string | number>(content);

  return (
    <div
      className={`${style} p-2 flex items-center justify-between font-extrabold`}
      data-value={value}
    >
      {label && <label htmlFor="label">{label}</label>}
      <input
        className={`${bgAndTxt} border-2 rounded-lg px-4 min-w-72 min-h-9`}
        onChange={(e) => {
          setValue(e.target.value);
          handleChange(e.target.value);
        }}
        name={label}
        type={type ? type : "text"}
        value={value}
      />
    </div>
  );
};

export default FieldInput;

interface FieldInputProps {
  label: string;
  type?: string;
  content: string | number;
  style?: string;
  bgAndTxt?: string;
  handleChange: (e: string) => void;
}
