import { UUID } from "crypto";
import { useState } from "react";
import { MdExpandCircleDown } from "react-icons/md";
import Checkbox from "./Checkbox";

const Filter: React.FC<FilterProps> = ({ title, items, label, addFilter }) => {
  const [showFilters, setShowFilters] = useState(true);
  return (
    <div>
      <div className="border-b-2 p-2 flex flex-row items-center justify-between">
        {`Filter by ${title}`}{" "}
        <MdExpandCircleDown
          onClick={() => setShowFilters(!showFilters)}
          className={`text-maize cursor-pointer text-xl hover:text-dark-maize transform ${
            showFilters ? "rotate-180" : ""
          }`}
        />
      </div>
      {items && (
        <ul className={showFilters ? "" : "h-1 overflow-hidden"}>
          {items.map((item: Item) => (
            <li key={item.id}>
              <Checkbox
                label={label}
                content={item.value}
                customCheckmark="🐻"
                handleChange={(label, target, isChecked) => {
                  addFilter(label, target, isChecked);
                }}
              />
            </li>
          ))}
        </ul>
      )}
    </div>
  );
};

export default Filter;
interface Item {
  id: UUID;
  value: string;
}
interface FilterProps {
  title: string;
  items: Item[];
  label: string;
  addFilter: (label: string, target: string, isChecked: boolean) => void;
}
