import React from "react";

const Checkbox: React.FC<CheckboxProps> = ({
  label,
  content,
  customCheckmark,
  handleChange,
}) => {
  const checkmarkContent = customCheckmark ? customCheckmark : "✓";

  return (
    <div className="flex items-center">
      <input
        onChange={(e) => {
          handleChange(
            label.replace(" ", "-").toLowerCase(),
            content,
            e.target.checked
          );
        }}
        type="checkbox"
        id={content}
        name={content}
        value={content}
        className="before:content[''] before:bg-blue-gray-500 peer relative m-2 text-center h-6 w-6 rounded-md cursor-pointer appearance-none rounded-sm border border-primary transition-all before:absolute before:left-2/4 before:top-2/4 before:block before:h-12 before:w-12 before:-translate-x-2/4 before:-translate-y-2/4 before:rounded-full before:opacity-0 before:transition-opacity after:absolute after:left-0 after:top-0 after:flex after:h-full after:w-full after:items-center after:justify-center checked:after:text-white hover:before:opacity-10 text-lg"
        style={{
          "--checkmark-content": `'${checkmarkContent}'`,
        }}
      />
      <label htmlFor={content}>{content}</label>
    </div>
  );
};

export default Checkbox;

interface CheckboxProps {
  label: string;
  content: string;
  customCheckmark?: string;
  handleChange: (label: string, target: string, isChecked: boolean) => void;
}
