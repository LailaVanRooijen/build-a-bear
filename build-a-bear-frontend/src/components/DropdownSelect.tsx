import { useState } from "react";

const DropdownSelect: React.FC<DropdownSelectProps> = ({
  label,
  options,
  style,
  bgAndTxt,
  handleChange,
}) => {
  const [value, setValue] = useState<string>(options[0]);
  return (
    <div
      className={`${style} p-2 flex items-center justify-between font-extrabold`}
      data-value={value}
    >
      {label && (
        <label className="capitalize" htmlFor={label}>
          {label}
        </label>
      )}

      <select
        className={`${bgAndTxt} rounded-lg px-4 min-w-72 min-h-9 border-2`}
        name={label}
        id={label}
        onChange={(e) => {
          setValue(e.target.value);
          handleChange(e.target.value);
        }}
      >
        <option className={`${bgAndTxt}`}>Select</option>
        {options &&
          options.map((option: string) => (
            <option
              className={`${bgAndTxt}`}
              key={option.replace(" ", "-")}
              value={option}
            >
              {option}
            </option>
          ))}
      </select>
    </div>
  );
};

export default DropdownSelect;

interface DropdownSelectProps {
  label: string;
  options: string[];
  style?: string;
  bgAndTxt?: string;
  handleChange: (e: string) => void;
}
